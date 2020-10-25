from flask import Flask, render_template, redirect, url_for, request
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.config['SQLALCHEMY_DATABASE_URI'] = 'postgres://user_app:123@localhost/db4'
db = SQLAlchemy(app)


class News(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    header = db.Column(db.String(1024), nullable=False)
    text = db.Column(db.String(1024), nullable=False)
    link = db.Column(db.String(1024))

    def __init__(self, header, text, link, blogs, authors):
        self.header = header
        self.text = text
        self.link = link
        self.blogs = [
            Blog(title=blog.strip()) for blog in blogs.split(',')
        ]
        self.authors = [
            Author(name=author.strip()) for author in authors.split(',')
        ]


class Blog(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    title = db.Column(db.String(512), nullable=False)

    news_id = db.Column(db.Integer, db.ForeignKey('news.id'), nullable=False)
    news = db.relationship('News', backref=db.backref('blogs', lazy=True))


class Author(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(512), nullable=False)

    news_id = db.Column(db.Integer, db.ForeignKey('news.id'), nullable=False)
    news = db.relationship('News', backref=db.backref('authors', lazy=True))


db.create_all()


@app.route('/', methods=['GET'])
def hello_world():
    return render_template('index.html')


@app.route('/main', methods=['GET', 'POST', 'DELETE'])
def main():
    return render_template('main.html', messages=(News.query.all()))


@app.route('/add_message', methods=['GET', 'POST'])
def add_message():
    header = request.form['header']
    text = request.form['text']
    link = request.form['link']
    authors = request.form['author']
    blogs = request.form['blog']

    db.session.add(News(header, text, link, authors, blogs))
    db.session.commit()

    return redirect(url_for('main'))


@app.route('/del_message', methods=['POST', 'DELETE', 'GET'])
def del_message():
    id_1 = request.form['id']

    db.session.query(Author).filter(Author.news_id == id_1).delete()
    db.session.query(Blog).filter(Blog.news_id == id_1).delete()
    db.session.query(News).filter(News.id == id_1).delete()
    db.session.commit()

    return redirect(url_for('main'))


@app.route('/update_message', methods=['POST', 'GET'])
def update_message():
    id_2 = request.form['id_up']
    header = request.form['header1']
    text = request.form['text1']
    link = request.form['link1']
    title = request.form['blog1']
    name = request.form['author1']

    db.session.query(News).filter(News.id == id_2). \
        update({
        'header': header,
        'text': text,
        'link': link})
    db.session.query(Blog).filter(Blog.news_id == id_2). \
        update({
        'title': title})
    db.session.query(Author).filter(Author.news_id == id_2). \
        update({
        'name': name})
    db.session.commit()

    return redirect(url_for('main'))

