from django.shortcuts import render,redirect
from login_app.models import *
from django.contrib import messages

def books(request):
    context={
        'the_user' : USER.objects.get(id=request.session['user_id']),
        'users' : USER.objects.all(),
        'books' : Book.objects.all()
    }
    return render(request,'all_books.html',context)

def add(request):
    errors = Book.objects.book_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/books')
    else:
        this_user=USER.objects.get(id=request.session['user_id'])
        this_book=Book.objects.create(title=request.POST['title'],desc=request.POST['desc'],
        users=USER.objects.get(id=request.session['user_id']))
        this_book.manyusers.add(this_user)
        return redirect('/books')

def favor(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_user=USER.objects.get(id=request.session['user_id'])
    this_user.manybooks.add(this_book)
    return redirect('/books')

def favedDetail(request,book_id):
    context = {
        'the_user' : USER.objects.get(id= request.session['user_id']),
        'this_book' : Book.objects.get(id=book_id)
    }
    return render(request,'details.html',context)

def update(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_book.desc=request.POST['new_desc']
    this_book.save()
    return redirect(f'/details/{book_id}')

def delete(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_book.delete()
    return redirect('/books')

def delete_fav(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_user=USER.objects.get(id=request.session['user_id'])
    this_user.manybooks.remove(this_book)
    return redirect('/books')
# Create your views here.
