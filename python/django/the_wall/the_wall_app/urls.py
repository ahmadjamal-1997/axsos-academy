from django.urls import path
from . import views

urlpatterns = [
    path('wall',views.wall),
    path('massage/<the_user_id>', views.post),
    path('comment/<msg_id>/<user_id>', views.comment)
]
