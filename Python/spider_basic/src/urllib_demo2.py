import urllib
import urlparse
def urlencode():
    params={'socre':100,'name':'spide_basic','comment':'good'}
    
    #dictionary-->url ascii
    qs=urllib.urlencode(params)
    print(qs)
    #url ascii-->dictionary
    print(urlparse.parse_qs(qs))
    
def parse_qs():
    url='https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=0&rsv_idx=1&tn=baidu&wd=%E4%B8%AD%E6%96%87&rsv_pq=d56db5cf0000b807&rsv_t=d31fpvZqOnBaazfvvcmPgrfThdf3mPFvEnSrbatzRxIZxF5WClFeWrUYF2U&rqlang=cn&rsv_enter=1&rsv_sug3=15&rsv_sug1=22&rsv_sug7=100&rsv_sug2=0&inputT=7993&rsv_sug4=7994'
    result=urlparse.urlparse(url)
    print(result)
    params=urlparse.parse_qs(result.query)
    print(params)
if __name__=='__main__':
    urlencode()
    parse_qs()