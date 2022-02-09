from django.shortcuts import render,redirect
import random

def show(request):
    request.session['random_num']=random.randint(1, 100)
    print("random"+str(request.session['random_num']))
    return render(request,'great_number_game.html')

def result(request):
    request.session['user_guess']=int(request.POST['guess'])
    print("user"+str(request.session['user_guess']))
    if request.session['random_num']>request.session['user_guess']:
        request.session['width']='200px'
        request.session['height']='200px'
        request.session['background_color']='red'
        request.session['result']='Too Low!'
        return redirect('/')
    elif request.session['random_num']<request.session['user_guess']:
        request.session['width']='200px'
        request.session['height']='200px'
        request.session['background_color']='red'
        request.session['result']='Too High!'
        return redirect('/')
    else:
        request.session['width']='200px'
        request.session['height']='200px'
        request.session['background_color']='green'
        request.session['result'] = 'correct'
        return redirect('/')
    return redirect('/')




# Create your views here.
