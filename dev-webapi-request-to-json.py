import json
import requests
import json
import pprint
import boto3

def lambda_handler(event, context):
    url = 'https://zipcloud.ibsnet.co.jp/api/search'
    params = {'zipcode':'2330008'}
    res = requests.get(url, params=params)
    json_data = json.loads(res.text)
    pprint.pprint(json_data)
    
    s3 = boto3.resource('s3')
    # �o�P�b�g�����w��
    BUCKET_NAME = "work-webapi-output"
    object_key_name = "output/sample.json"
    
    bucket = s3.Bucket(BUCKET_NAME)
    # �I�u�W�F�N�g�𐶐�
    obj = bucket.Object(object_key_name)
    
    #json�f�[�^s3 output
    r = obj.put(Body = json.dumps(json_data))
    
    
    # TODO implement
    return {
        'statusCode': 200,
        'body': json.dumps('Hello from Lambda!')
    }
