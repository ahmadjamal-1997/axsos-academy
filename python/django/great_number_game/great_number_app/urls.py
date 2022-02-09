from django.urls import path
from . import views

urlpatterns = [
    path('', views.show),
    path('guess', views.result)
]