from flask import Flask,render_template
app = Flask(__name__)    

@app.route('/')
def cheacker():
    return render_template("cheackerboard.html")

@app.route('/<num>')
def change_row(num):
    a=int(num)/2
    return render_template("cheackerboard2.html", b=int(a))

@app.route('/<num1>/<num2>')
def colors(num1,num2):
    c=int(num1)/2
    d=int(num2)/2
    return render_template("cheackerboard3.html",c=int(c),d=int(d))

@app.route('/<num3>/<num4>/<color1>/<color2>')
def color_num(num3,num4,color1,color2):
    e=int(num3)/2
    f=int(num4)/2
    return render_template("cheackerboard4.html",e=int(e),f=int(f),color1=color1,color2=color2)
if __name__=="__main__":       
    app.run(debug=True)