from django.shortcuts import render,redirect
from .models import dojo,ninja

def show(request):
    context={
        "Dojos":dojo.objects.all()
    }
    return render(request,'dojos_and_ninjas.html',context)

def add_dojo(request):
    dojo.objects.create(name=request.POST['name'], city=request.POST['city'],state=request.POST['state'])
    return redirect('/')

def add_ninja(request):
    ninja.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
    dojo=Dojo.objects.get(id=request.POST['x']))
    return redirect('/')

def remove(request):
    v = dojo.objects.get(id=request.POST['delete_dojo'])
    v.delete()
    return redirect('/')

