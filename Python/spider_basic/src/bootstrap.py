import urllib
def progress(blk,blk_size,total_size):
    print('%d/%d-%.02f%%' % (blk*blk_size,total_size,(float)(blk*blk_size)*100/total_size))
def retrieve():
    fname,msg=urllib.urlretrieve('http://v3.bootcss.com/examples/carousel/', 'boot.html',reporthook=progress)
    print(fname)
if __name__=='__main__':
    retrieve()