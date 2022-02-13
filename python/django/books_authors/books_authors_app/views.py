from django.shortcuts import render,redirect
from .models import Book,Author

#the function adds the data entered in the form to the data base and redirect to the main page
def add_book(request):
    Book.objects.create(title=request.POST['title'],desc=request.POST['Description'])
    return redirect ('/')

#the function returns the main html when opening the link and after adding a book from (def add_book)
def show(request):
    context={
        'allbooks': Book.objects.all(),
    }
    return render(request,'books_authors.html',context)

#the function takes a number from the path which is the book id and returns a dict with the lists needed for the jinja
def desc(request,book_id):
    book_info=Book.objects.get(id=book_id)
    author=book_info.authors.all()
    authors=Author.objects.exclude(id__in = author.values_list('id', flat=True))
    cont={
        'book_info' : book_info,
        'author' : author,
        'authors' :authors
    }
    return render(request,'desc.html', cont)

#the function takes a number which is the book id and insert the selected author to the authors list of that book and redirects to the book page
def insert(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_author=Author.objects.get(id=request.POST['select_name'])
    this_book.authors.add(this_author)
    return redirect(f"books/{book_id}")

#the function adds the data entered in the form to the data base and redirect to the main page
def add_author(request):
    Author.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
    notes=request.POST['notes'])
    return redirect ('/desc1')

#the function returns the main html when opening the link and after adding an author from (def add_author)
def show1(request):
    context1={
        'allauthors' : Author.objects.all()
    }
    return render (request,'add_author.html',context1)

#the function takes a number from the path which is the author id and returns a dict with the lists needed for the jinja
def desc1(request,author_id):
    author_info=Author.objects.get(id=author_id)
    print(author_info)
    book=author_info.books.all()
    books=Book.objects.exclude(id__in = book.values_list('id', flat=True))
    cont1={
        'author_info' : author_info,
        'book' : book,
        'books' : books
    }
    return render(request,'author_desc.html', cont1)

#the function takes a number which is the author id and insert the selected book to the books list of that author and redirects to the author page
def insert1(request,author_id):
    this_author=Author.objects.get(id=author_id)
    this_book=Book.objects.get(id=request.POST['book_select_name'])
    this_author.books.add(this_book)
    return redirect(f"authors/{author_id}")


# Create your views here.
