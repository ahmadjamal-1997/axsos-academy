from django.db import models
import re 
import bcrypt
class USERManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors["first_name"] = "first name should be at least 5 characters"
        if len(postData['last_name']) < 2:
            errors["last_name"] = "last name should be at least 5 characters"
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['email']):               
            errors['email'] = "Invalid email address!"
        if len(postData['password']) < 8:
            errors["password"] = "password should be at least 10 characters"
        if postData['password']!=postData['confirm_pw']:
            errors['login_password']="password does not match"
        this_user=USER.objects.filter(email=postData['email'])
        if this_user:
            errors['exsistance']="this email already exisit"
        return errors
    def login_validator(self,postData):
        errors={}
        EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
        if not EMAIL_REGEX.match(postData['login_email']):               
            errors['login_email'] = "Invalid email address!"
        return errors
    def book_validator(self,postData):
        errors = {}
        if len(postData['title'])<1 :
            errors['title'] ="title required"
        if len(postData['desc'])<8 :
            errors['desc']= "desc is too short"
        return errors


class USER(models.Model):
    first_name = models.CharField(max_length=255)
    last_name= models.CharField(max_length=255)
    email = models.TextField()
    password= models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=USERManager()


class  Book(models.Model):
    title=models.CharField(max_length=255)
    desc=models.TextField()
    users=models.ForeignKey(USER, related_name="books", on_delete = models.CASCADE)
    manyusers = models.ManyToManyField(USER, related_name="manybooks")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    objects=USERManager()

