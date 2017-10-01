import googlemaps
from datetime import datetime

# pip install -U googlemaps
gmaps = googlemaps.Client(key='AIzaSyA7Ch4LDeT3SpC_oBwVPYDTCalrryea7BM')


def gmap_polyline(start, stop):
# Request directions via walking
	now = datetime.now()
	directions_result = gmaps.directions(start,
	                                     stop,
	                                     mode="walking",
	                                     departure_time=now,
	                                     alternatives=True)


	print len(directions_result)
	results = []
	for polyline in directions_result:
		results.append(polyline['overview_polyline']['points'])

	print results	
	return results