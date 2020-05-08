from flask import Flask, json

app = Flask(__name__)

@app.route('/hello', methods=['GET'])
def hello():
  return "hello"