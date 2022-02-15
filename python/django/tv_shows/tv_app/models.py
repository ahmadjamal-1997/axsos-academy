from django.db import models


class SHOWManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 2:
            errors["title"] = "title name should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Network name should be at least 3 characters"
        if len(postData['desc']) < 10:
            errors["desc"] = "the Description should be at least 10 characters"
        return errors

    def edit_validator(self,postData):
        errors = {}
        if len(postData['new_title']) < 2:
            errors["new_title"] = "title name should be at least 2 characters"
        if len(postData['new_network']) < 3:
            errors["new_network"] = "Network name should be at least 3 characters"
        if len(postData['new_desc']) < 10:
            errors["new_desc"] = "the Description should be at least 10 characters"
        return errors



class SHOW (models.Model):
        title = models.CharField(max_length=255)
        network = models.CharField(max_length=255)
        release_date = models.DateTimeField()
        desc = models.TextField()
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)
        objects = SHOWManager()

# Create your models here.
