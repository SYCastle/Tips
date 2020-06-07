import json
import boto3
import os

def lambda_handler(event, context):
    
    print('## ENVIRONMENT VARIABLES')
    print(os.environ)
    print('## EVENT')
    print(event)
    
    #S3にアップロードされた画像データ情報を取得
    s3 = boto3.client("s3")
    bucket_name = event['Records'][0]['s3']['bucket']['name']
    target_file = event['Records'][0]['s3']['object']['key'] # include prefix   bucket_name/prefix/file
    input_data = s3.get_object(Bucket=bucket_name, Key=target_file)
    
    
    print(bucket_name)
    print(target_file)
    
    #import logging
    #logger = logging.getLogger() 
    #logLevel=logging.INFO
    
    #logger.info(bucket)
    #logger.info(key)

    #https://www.qoosky.io/techs/9433d6b05d
    glue = boto3.client('glue')
    response = glue.start_job_run(
        JobName = 'sample-job-using-pygresql2',
        Arguments = {
            '--bucket_name': bucket_name,
            '--target_file': target_file
        })
    return response
    