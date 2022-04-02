# Reference: https://github.com/DexterInd/BrickPi/blob/master/Software/BrickPi_Python/Project_Examples/Thingspeak%20Temperature%20Logging/Thermometer_Thingspeak.py
# This program writes a set of data to ThingSpeak every 16 seconds

import http.client, urllib.request, urllib.parse, urllib.error
import time
import math
import random

def writeData():
  NO2 = 500 + random.randrange(-100, 100, 3)
  C2H5CH = 500 + random.randrange(-100, 100, 3)
  VOC = 500 + random.randrange(-100, 100, 3)
  CO = 100 + random.randrange(-100, 100, 3)
  longi = 114.177216
  latti = 22.302711

  params = urllib.parse.urlencode({'field1': NO2, 'field2': C2H5CH, 'field3': VOC, 'field4': CO, 'long': longi, 'lat': latti, 'key':'KLC2SZJRBOGHFEQK'})     # use your API key generated in the thingspeak channels for the value of 'key'
  # temp is the data you will be sending to the thingspeak channel for plotting the graph. You can add more than one channel and plot more graphs
  headers = {"Content-typZZe": "application/x-www-form-urlencoded","Accept": "text/plain"}
  conn = http.client.HTTPConnection("api.thingspeak.com:80")                
  try:
    conn.request("POST", "/update", params, headers)
    response = conn.getresponse()
    print((NO2, C2H5CH, VOC, CO, longi, latti))     
    print((response.status, response.reason))
    data = response.read()
    conn.close()
  except:
    print("connection failed")

#sleep for 16 seconds (api limit of 15 secs)

while True:
  writeData()
  time.sleep(16) 
