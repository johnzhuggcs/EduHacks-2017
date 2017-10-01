from flask import Flask, request, render_template, url_for, redirect
from gmap import gmap_polyline
app = Flask(__name__)

@app.route('/', methods=['GET'])
def hello_world():
    return render_template('start.html')


@app.route('/map', methods=['POST'])
def map():
	start = request.form['start']
	stop = request.form['stop']

	polyline = gmap_polyline(start, stop)
	polyline = polyline[0]

	polyline = str(polyline)
	print type(polyline)
	return render_template('map.html', polyline=polyline)


