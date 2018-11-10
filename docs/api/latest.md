# API Docs - v4.0.19-SNAPSHOT

## Geo

### findCityFromIP *<a target="_blank" href="https://wso2.github.io/siddhi/documentation/siddhi-4.0/#function">(Function)</a>*

<p style="word-wrap: break-word">This function returns the city that is related to the give IP address.</p>

<span id="syntax" class="md-typeset" style="display: block; font-weight: bold;">Syntax</span>
```
<STRING> geo:findCityFromIP(<STRING> ip)
```

<span id="query-parameters" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">QUERY PARAMETERS</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Default Value</th>
        <th>Possible Data Types</th>
        <th>Optional</th>
        <th>Dynamic</th>
    </tr>
    <tr>
        <td style="vertical-align: top">ip</td>
        <td style="vertical-align: top; word-wrap: break-word">The IP address of which the related city needs to be fetched.</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">STRING</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
</table>

<span id="examples" class="md-typeset" style="display: block; font-weight: bold;">Examples</span>
<span id="example-1" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">EXAMPLE 1</span>
```
define stream IpStream(ip string);
from IpStream
select geo:getCity(ip) as city
insert into outputStream;
```
<p style="word-wrap: break-word">This query returns the corresponding city of the given IP address.</p>

### findCountryFromIP *<a target="_blank" href="https://wso2.github.io/siddhi/documentation/siddhi-4.0/#function">(Function)</a>*

<p style="word-wrap: break-word">This function returns the country that is related to the given IP address.</p>

<span id="syntax" class="md-typeset" style="display: block; font-weight: bold;">Syntax</span>
```
<STRING> geo:findCountryFromIP(<STRING> ip)
```

<span id="query-parameters" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">QUERY PARAMETERS</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Default Value</th>
        <th>Possible Data Types</th>
        <th>Optional</th>
        <th>Dynamic</th>
    </tr>
    <tr>
        <td style="vertical-align: top">ip</td>
        <td style="vertical-align: top; word-wrap: break-word">The IP address of which the related country needs to be fetched.</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">STRING</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
</table>

<span id="examples" class="md-typeset" style="display: block; font-weight: bold;">Examples</span>
<span id="example-1" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">EXAMPLE 1</span>
```
define stream IpStream(ip string);
from IpStream
select geo:getCountry(ip) as country 
insert into outputStream;
```
<p style="word-wrap: break-word">This query returns the corresponding country of the given IP address.</p>

### geocode *<a target="_blank" href="https://wso2.github.io/siddhi/documentation/siddhi-4.0/#stream-function">(Stream Function)</a>*

<p style="word-wrap: break-word">The geo code stream function uses basic details relating to a location (e.g., street name, number,etc.) as the input and returns the longitude, latitude, and the address of that location. </p>

<span id="syntax" class="md-typeset" style="display: block; font-weight: bold;">Syntax</span>
```
geo:geocode(<STRING> location)
```

<span id="query-parameters" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">QUERY PARAMETERS</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Default Value</th>
        <th>Possible Data Types</th>
        <th>Optional</th>
        <th>Dynamic</th>
    </tr>
    <tr>
        <td style="vertical-align: top">location</td>
        <td style="vertical-align: top; word-wrap: break-word">Location details(Street name, number etc.).</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">STRING</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
</table>
<span id="extra-return-attributes" class="md-typeset" style="display: block; font-weight: bold;">Extra Return Attributes</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Possible Types</th>
    </tr>
    <tr>
        <td style="vertical-align: top">longitude</td>
        <td style="vertical-align: top; word-wrap: break-word">The longitude of the location.</td>
        <td style="vertical-align: top">DOUBLE</td>
    </tr>
    <tr>
        <td style="vertical-align: top">latitude</td>
        <td style="vertical-align: top; word-wrap: break-word">The latitude of the location.</td>
        <td style="vertical-align: top">DOUBLE</td>
    </tr>
    <tr>
        <td style="vertical-align: top">address</td>
        <td style="vertical-align: top; word-wrap: break-word">Location details.</td>
        <td style="vertical-align: top">STRING</td>
    </tr>
</table>

<span id="examples" class="md-typeset" style="display: block; font-weight: bold;">Examples</span>
<span id="example-1" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">EXAMPLE 1</span>
```
geocode("5 Avenue Anatole France, 75007 Paris, France")
```
<p style="word-wrap: break-word">This query returns the longitude and latitude of the given location with the location details. The expected results are 48.8588871d, 2.2944861d, "5 Avenue Anatole France, 75007 Paris, France"</p>

### getlocation *<a target="_blank" href="https://wso2.github.io/siddhi/documentation/siddhi-4.0/#stream-function">(Stream Function)</a>*

<p style="word-wrap: break-word">stream function</p>

<span id="syntax" class="md-typeset" style="display: block; font-weight: bold;">Syntax</span>
```
geo:getlocation(<STRING> ip)
```

<span id="query-parameters" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">QUERY PARAMETERS</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Default Value</th>
        <th>Possible Data Types</th>
        <th>Optional</th>
        <th>Dynamic</th>
    </tr>
    <tr>
        <td style="vertical-align: top">ip</td>
        <td style="vertical-align: top; word-wrap: break-word">login ip address</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">STRING</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
</table>
<span id="extra-return-attributes" class="md-typeset" style="display: block; font-weight: bold;">Extra Return Attributes</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Possible Types</th>
    </tr>
    <tr>
        <td style="vertical-align: top">longitude</td>
        <td style="vertical-align: top; word-wrap: break-word">Longitude of the location</td>
        <td style="vertical-align: top">DOUBLE</td>
    </tr>
    <tr>
        <td style="vertical-align: top">latitude</td>
        <td style="vertical-align: top; word-wrap: break-word">Latitude of the location</td>
        <td style="vertical-align: top">DOUBLE</td>
    </tr>
</table>

<span id="examples" class="md-typeset" style="display: block; font-weight: bold;">Examples</span>
<span id="example-1" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">EXAMPLE 1</span>
```
getlocation("ip address")
```
<p style="word-wrap: break-word">This will returns the Longitude and latitude of the given login ip</p>

### reversegeocode *<a target="_blank" href="https://wso2.github.io/siddhi/documentation/siddhi-4.0/#stream-function">(Stream Function)</a>*

<p style="word-wrap: break-word">This extension transforms pairs of latitude and longitude coordinates into precise address information. The output contains string properties including the 'streetNumber', 'neighborhood', 'route', 'administrativeAreaLevelTwo', 'administrativeAreaLevelOne', 'country', 'countryCode', 'postalCode', and the 'formattedAddress' in the given order. However, this information is not available for all the geo coordinates. e.g., If the latitude and longitude represent a place in a forest, only the high level information such as the country is returned. In such scenarios, "N/A" is returned as the value for return attributes of which the values cannot be derived.</p>

<span id="syntax" class="md-typeset" style="display: block; font-weight: bold;">Syntax</span>
```
geo:reversegeocode(<DOUBLE> longitude, <DOUBLE> latitude)
```

<span id="query-parameters" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">QUERY PARAMETERS</span>
<table>
    <tr>
        <th>Name</th>
        <th style="min-width: 20em">Description</th>
        <th>Default Value</th>
        <th>Possible Data Types</th>
        <th>Optional</th>
        <th>Dynamic</th>
    </tr>
    <tr>
        <td style="vertical-align: top">longitude</td>
        <td style="vertical-align: top; word-wrap: break-word">The longitude value of the required location.</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">DOUBLE</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
    <tr>
        <td style="vertical-align: top">latitude</td>
        <td style="vertical-align: top; word-wrap: break-word">The latitude value of the required location.</td>
        <td style="vertical-align: top"></td>
        <td style="vertical-align: top">DOUBLE</td>
        <td style="vertical-align: top">No</td>
        <td style="vertical-align: top">No</td>
    </tr>
</table>

<span id="examples" class="md-typeset" style="display: block; font-weight: bold;">Examples</span>
<span id="example-1" class="md-typeset" style="display: block; color: rgba(0, 0, 0, 0.54); font-size: 12.8px; font-weight: bold;">EXAMPLE 1</span>
```
reversegeocode(6.909785, 79.852603)
```
<p style="word-wrap: break-word">This query returns the precise address information of the given location. In this example, it returns the following value:<br>&nbsp;"27", "N/A", "Palm Grove", "Colombo", "Western Province",                        "Sri Lanka", "LK", "00300", "27 Palm Grove, Colombo 00300, Sri Lanka"</p>

