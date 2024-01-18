# springboot-rest-api-microservice
simple apps for soap with springboot


server port : 9091


curl --location 'http://localhost:9091/external/services/ws/sample-service' \
--header 'Content-Type: text/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:orac="http://www.oracle.com" xmlns:v1="http://www.oracle.com/external/services/sampleservice/request/v1.0">
<soapenv:Header>
<orac:authenticationheader>
<orac:username>xxx</orac:username>
<orac:password>xxx</orac:password>
</orac:authenticationheader>
</soapenv:Header>
<soapenv:Body>
<v1:sampleservicerq>
<v1:service_id>1234567890</v1:service_id>
<v1:order_type>CH</v1:order_type>
<v1:type>PO</v1:type>
<v1:trx_id>c6714ec0-b379-11e9-889b-7f7167f4f72d</v1:trx_id>
</v1:sampleservicerq>
</soapenv:Body>
</soapenv:Envelope>
'