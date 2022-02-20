from django.shortcuts import render,redirect
from django.contrib import messages
from .models import USER
import bcrypt   

def show(request):
    return render(request,'login.html')

def register(request):
    errors = USER.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    elif len(USER.objects.filter(email=request.POST['email'])) > 0 :
        messages.error(request, "this email already exists")
        return redirect('/')
    else:
        password = request.POST['password']
        confirm_pw=request.POST['confirm_pw']
        if password==confirm_pw:
            pw_hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
            this_user=USER.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],email=request.POST['email'],
            password=pw_hash)
            request.session['user_id'] = this_user.id
        return redirect('/books')

def login(request):
    errors = USER.objects.login_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
    if not USER.objects.filter(email=request.POST['login_email']):
        messages.error(request, "not signed in! register now")
        return redirect('/')
    else:
        this_user=USER.objects.get(email=request.POST['login_email'])
        if this_user:
            if bcrypt.checkpw(request.POST['login_password'].encode(), this_user.password.encode()):
                request.session['user_id'] = this_user.id
                return redirect('/books')
            else:
                messages.error(request, "the password is incorrect")
                return redirect("/")

def success(request):
    user_name=USER.objects.get(id=request.session['user_id'])
    context={
        'user_name': user_name
    }
    return render(request,'success.html',context)


# Create your views here.
