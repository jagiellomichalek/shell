# -*- coding: utf-8 -*-

import re
import glob
import codecs ### added
from lxml import etree
# define a parser for XML node
parser = etree.XMLParser(recover=True, encoding='ascii')
userId = 0
# get a file one by one
#for aFile in glob.glob('.\\dataset1\\*.xml'):
for aFile in glob.glob('./dataset1/*.xml'):  ###
    #print(aFile) ### for debug
    # this is to use pattern getting only the gender from filename. it will group  file name into
    # (.)(\dataset1\28451.)(male)(.27.Internet.Aquarius.xml) from the pattern i defined
    # this means to use matchObj.group(3) to get a gender tag from a file name
    matchObj = re.match( '(.*?[.])(.*?[.])(.*?)([.].*)', aFile) 
    tree = etree.parse(aFile, parser=parser)
    root = tree.getroot() # find the root
    postTag = root.findall('.//post') # get only the post tag in XML
    # filename is create as userId_gender.txt format
    #createTxtFile = open("%s_%s.txt" % (str('{0:04}'.format(userId)), 
    #                                    matchObj.group(3)),"w") 
    ### open file with UTF-8 coding
    createTxtFile = codecs.open("%s_%s.txt" % (str('{0:05}'.format(userId)),matchObj.group(3)),"w",'utf-8') 
    for child in postTag:
        # to keep post and gender in a format such as {gender, post} as
        # using only space might cliche with the plain text written by user
        createTxtFile.write('{%s,%s}\r\n' % (matchObj.group(3), child.text.strip()))
    createTxtFile.close()
    userId += 1
