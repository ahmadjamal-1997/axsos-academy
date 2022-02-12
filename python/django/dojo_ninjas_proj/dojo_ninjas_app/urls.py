from django.urls import path
from . import views

urlpatterns = [
    path('', views.show),
    path('dojoresult', views.add_dojo),
    path('ninjaresult',views.add_ninja),
    path('delete', views.remove)
]
