from django.shortcuts import render,redirect
from login_app.models import USER,Massage,Comment


def wall(request):
    context={
        'users' : USER.objects.all(),
        'massages' : Massage.objects.all(),
        'comments' : Comment.objects.all(),
        'the_user' : USER.objects.get(id=request.session['user_id'])
    }
    return render (request,'the_wall.html',context)

def post(request,the_user_id):
    Massage.objects.create(massage=request.POST['massage'],users=USER.objects.get(id=the_user_id))
    return redirect (f'/wall')

def comment(request,msg_id,user_id):
    Comment.objects.create(comment=request.POST['comment'],users=USER.objects.get(id=user_id)
    ,massage=Massage.objects.get(id=msg_id))
    # request.session['this_massage']=msg_id
    return redirect(f'/wall')








# Create your views here.
