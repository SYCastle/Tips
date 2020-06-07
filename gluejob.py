import pandas as pd
import csv
from pgdb import connect
import boto3
import sys
from awsglue.utils import getResolvedOptions


print("hello")

#https://www.qoosky.io/techs/9433d6b05d
#https://docs.aws.amazon.com/ja_jp/glue/latest/dg/aws-glue-api-crawler-pyspark-extensions-get-resolved-options.html
args = getResolvedOptions(sys.argv, [
    'JOB_NAME',
    'bucket_name',
    'target_file'])

print("bucket_name: " + args[0])
print("target_file: " + args[1])


df = pd.read_csv('s3://aws-glue-sample-sawada/target-triger/prefix_yyyymmdd.csv', encoding='utf-8') #shift-jis���ƕ����������ăC���|�[�g�����

#print(df.head())

#print(df.drop(0).head())

csv = df.to_csv(header=False, index=False)
print(csv)

# delete index info
#df.drop(0)  #read_csv�͎����I�Ɉ�s�ڂ��w�b�_�Ƃ��Ĉ������߁A�s�v


con = connect(database='', host='',user='', password='')
cursor = con.cursor()

tbl_name = 'persons'
sql = 'truncate ' + tbl_name
cursor.execute(sql)

cursor.copy_from(csv,tbl_name,'csv') #copy_from...�����ǉ�

con.commit()







