from django.urls import path
from . import views

urlpatterns = [
    path('', views.show),
    path('authors',views.show1),
    path('add_book', views.add_book),
    path('add_author', views.add_author),
    path('books/<book_id>', views.desc),
    path('authors/<author_id>' , views.desc1),
    path('add<book_id>', views.insert),
    path('plus<author_id>', views.insert1)
]