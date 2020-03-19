# SimpleWeatherApp

### Requirement
JDK version Required : JDK 8

##caveats
In open web api(https://openweathermap.org/weather-conditions) there is no Sunny weather condition due to this ,
I have added a condition to check if the weather is > than 20 C and weather is "clear" I am considering as sunny.
Also the API used provides weather for every 3 hours and we are checking in a day if this temp reaches that threshold at any point.
For Temp check I am using average instead of max just as a personal preference.

##design
we are using observer pattern to have a API call and check for changes and notify the display unit.
This will allow us to call display unit only when there is a change in some value .We can add more display/processing functions later by adding an observer.
we are scheduling the thread run every X secs( configurable in properties file ) to call API and check for the response.
If the response is different from older response then we notify observers with response POJO.
The observer will decode the response and take action.


##config
WeatherAppConfig.properties holds all the config for the app ,here is the below description for each .
<ul>
<li>language -> language for resource bundle ,at the moment only default bundle has been kept .Later point more languages can be added and configured via this </li>
<li>country -> county for the resource bundle ,at the moment only default bundle has been kept .Later point more languages can be added and configured via this</li>
<li>api.url -> API url for open weather 5 days /3 hour API call .</li>
<li>api.filter.q -> location of search in API</li>
<li>api.filter.appid -> app id for API ,please generate a free one in open weather map website if this is invalid</li>
<li>api.filter.units -> measuring units for the API</li>
<li>max.temp -> max temp to check to calculate the no of days .</li>
<li>weather.type -> weather type string we are checking.</li>
<li>weather.print.datetime.format -> date and time format we are displaying to console</li>
<li>weather.api.call.every.x.sec -> number of seconds we call the API to check for changes .</li>
</ul>
