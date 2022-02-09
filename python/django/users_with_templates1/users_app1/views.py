from django.shortcuts import render,redirect
from .models import users

def show(request):
    context={
        'user': users.objects.all()
    }
    return render(request,'users_with_templates.html',context)

def process(request):
    users.objects.create(first_name= request.POST['first_name'],last_name=request.POST['last_name'],email_address=request.POST['email'],age=request.POST['age'])
    return redirect('/')



