from django.shortcuts import render,redirect
from .models import SHOW
from django.contrib import messages

def show(request):

    context={
        'shows': SHOW.objects.all()
    }
    return render(request,'show.html',context)

def add(request):
    return render(request,'tv_show.html')

def create(request):
    errors = SHOW.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/new')
    else:
        this_show=SHOW.objects.create(title=request.POST['title'],network=request.POST['network'],release_date=request.POST['date'],desc=request.POST['desc'])
        num=this_show.id
        messages.success(request, "show successfully updated")
    return redirect(f'/{num}')

def details(request,show_id):
    this_show=SHOW.objects.get(id=show_id)
    context1={
        'this_show' : this_show
    }
    return render(request,'show_details.html',context1)

def edit(request,show_id):
    this_show=SHOW.objects.get(id=show_id)
    context={
        'show' : this_show
    }
    return render(request,'show_edit.html',context)

def update(request,show_id):
    errors = SHOW.objects.edit_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/new')
    else:
        c=SHOW.objects.get(id=show_id)
        c.title=request.POST['new_title']
        c.network=request.POST['new_network']
        c.date=request.POST['new_date']
        c.desc=request.POST['new_desc']
        c.save()
        return redirect(f'/{show_id}')

def delete(request,show_id):
    c=SHOW.objects.get(id=show_id)
    c.delete()
    return redirect('/')
# Create your views here.


