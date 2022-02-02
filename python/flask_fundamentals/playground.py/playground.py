from flask import Flask, render_template
app = Flask(__name__)   
@app.route('/play')    
def playground():
    return render_template("playground.html")

@app.route('/play/<x>')
def boxes(x):
    return render_template("playground2.html",x=int(x))

@app.route('/play/<x>/<color>')
def change_color(x,color):
    return render_template("playground3.html",x=int(x),color=color)

if __name__=="__main__":
    app.run(debug=True)

