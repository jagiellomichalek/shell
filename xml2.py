import csv
import requests
import xml.etree.ElementTree as ET
#from lxml import etree
import codecs

def parseXML(xmlfile):

    # create element tree object
    tree = ET.parse(xmlfile)

    # get root element
    root = tree.getroot()

    # create text file

    parsedFile = codecs.open('parsedXML.txt','a', encoding='utf-8')

    output =[]


    for i in  root.findall('./'): # edit this line to include the root and the first node of the file

        output.append(i.attrib)



    for vals in output :

        for one_item in vals:


           parsedFile.write(one_item +": " + vals[one_item].encode("utf-8"))
           parsedFile.write("\n\n")
        parsedFile.write("\n")
        parsedFile.write("-----------------------------------------------------------------------\n")


    parsedFile.close()




parseXML('male.xml')
