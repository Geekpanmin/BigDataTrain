# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

# Create your views here.
def imooc(request):
    #return HttpResponse("hello imooc")
    #if-else
    return render(request, 'blog2/imooc.html')