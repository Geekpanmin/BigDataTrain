import urllib
def getHtml(url):
    page=urllib.urlopen(url)
    html=page.read()
    return html
html=getHtml("https://image.baidu.com/search/index?tn=baiduimage&ipn=r&ct=201326592&cl=2&lm=-1&st=-1&fr=&sf=1&fmq=1459502303089_R&pv=&ic=0&nc=1&z=&se=1&showtab=0&fb=0&width=&height=&face=0&istype=2&ie=utf-8&word=%E9%A3%8E%E6%99%AF")
print html