from django.db import models
import re 
import bcrypt
class USERManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "first name should be at least 5 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "first name should be at least 5 characters"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):               
            errors['email'] = "Invalid email address!"
        if len(postData['password']) < 8:
            errors["password"] = "password should be at least 10 characters"
        if postData['password']!=postData['confirm_pw']:
            errors['login_password']="password does not match"
        return errors
    def login_validator(self,postData):
        errors={}
        this_user=USER.objects.get(email=postData['login_email'])
        if not bcrypt.checkpw(postData['login_password'].encode(), this_user.password.encode()):
            errors['not_match']="password is not correct"
        return errors

class USER(models.Model):
    first_name = models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email = models.TextField()
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=USERManager()
# Create your models here.
