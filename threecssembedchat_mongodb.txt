mongo --host 172.27.108.72 --eval 'db = db.getSiblingDB("threecssembedchat");db.createUser({user: "threecssembedchat",pwd: "123456",roles: [ "readWrite", "dbAdmin" ]})'
