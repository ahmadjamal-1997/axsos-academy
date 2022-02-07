from django.shortcuts import render
def form(request):
    return render(request,'survey.html')

def result(request):

    name=request.POST['username']
    location1=request.POST['location']
    language1=request.POST['language']
    comment1=request.POST['comment']
    context={
        'form_name' : name,
        'form_location' : location1,
        'form_language': language1,
        'form_comment' : comment1
        }
    return render(request,'results.html',context)

# Create your views here.
