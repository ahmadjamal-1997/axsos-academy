from flask import Flask, render_template,request,redirect,session
app = Flask(__name__)
app.secret_key='keep it secret'
@app.route('/')
def count():
    if not "count" in session:
        session['count']=0
    else : 
        session['count']+=1
    return render_template('counter.html',count=session['count'])

@app.route('/result2', methods=['post'])
def clear():
    session.clear()
    return redirect('/')

@app.route('/result',methods=['post'])
def add2():
    session['count']+=1
    return redirect('/')

@app.route('/result3', methods=['post'])
def increment():
    session['num']=int(request.form['number'])-1
    session['count']+=session['num']
    return redirect('/')

if __name__ == "__main__":
    app.run(debug=True)