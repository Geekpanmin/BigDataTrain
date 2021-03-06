# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.
from django.contrib import admin
class BlogsPost(models.Model):
     title=models.CharField(max_length=150)
     body=models.TextField()
     timestamp=models.DateTimeField()
     def __unicode__(self):
            return self.title
#继承
class BlogPostAdmin(admin.ModelAdmin):
    list_display=('title','timestamp')

class Article(models.Model):
        title1=models.CharField(max_length=150,default='imooc blog title')
        content=models.TextField(null=True)
        
        def __unicode__(self):
            return self.title1
admin.site.register(BlogsPost)
admin.site.register(Article)