from django.urls import path
from . import views

urlpatterns = [
    path('', views.show),
    path('new', views.add),
    path('create', views.create),
    path('<show_id>', views.details),
    path('<show_id>/edit', views.edit),
    path('update/<show_id>', views.update),
    path('delete/<show_id>', views.delete)
]