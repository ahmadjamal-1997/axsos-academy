from django.urls import path
from . import views

urlpatterns = [
    path('books', views.books),
    path('add', views.add),
    path('favor/<book_id>', views.favor),
    path('details/<book_id>', views.favedDetail),
    path('update/<book_id>', views.update),
    path('delete/<book_id>', views.delete),
    path('delete_fav/<book_id>', views.delete_fav)

]