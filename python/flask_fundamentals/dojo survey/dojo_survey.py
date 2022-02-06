from flask import Flask, render_template,request
app = Flask(__name__)
@app.route('/',methods=['post'])
def index():
    return render_template("dojo_survey.html")

@app.route('/result',methods=["post"])
def show():
    form_name=request.form['username']
    form_location=request.form['location']
    form_language=request.form['language']
    form_comment=request.form ['comment']
    return render_template('show.html',form_name=form_name,form_location=form_location,form_language=form_language,form_comment=form_comment)
if __name__ == "__main__":
    app.run(debug=True)