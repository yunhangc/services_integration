@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  event_hub startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

@rem Add default JVM options here. You can also use JAVA_OPTS and EVENT_HUB_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windowz variants

if not "%OS%" == "Windows_NT" goto win9xME_args
if "%@eval[2+2]" == "4" goto 4NT_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*
goto execute

:4NT_args
@rem Get arguments from the 4NT Shell from JP Software
set CMD_LINE_ARGS=%$

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\event_hub-1.0-SNAPSHOT.jar;%APP_HOME%\lib\spring-cloud-starter-hystrix-1.0.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-web-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-actuator-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-cloud-starter-hystrix-dashboard-1.0.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-jetty-1.2.5.RELEASE.jar;%APP_HOME%\lib\kafka_2.10-0.8.2.1.jar;%APP_HOME%\lib\spring-integration-kafka-1.1.1.RELEASE.jar;%APP_HOME%\lib\gson-2.3.1.jar;%APP_HOME%\lib\feign-gson-8.10.0.jar;%APP_HOME%\lib\feign-slf4j-8.10.0.jar;%APP_HOME%\lib\spring-cloud-starter-1.0.3.RELEASE.jar;%APP_HOME%\lib\spring-cloud-netflix-core-1.0.3.RELEASE.jar;%APP_HOME%\lib\hystrix-core-1.4.10.jar;%APP_HOME%\lib\hystrix-metrics-event-stream-1.4.10.jar;%APP_HOME%\lib\hystrix-javanica-1.4.10.jar;%APP_HOME%\lib\mongo-java-driver-2.12.5.jar;%APP_HOME%\lib\spring-core-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-tx-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-data-mongodb-1.6.2.RELEASE.jar;%APP_HOME%\lib\spring-boot-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-logging-1.2.4.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.14.jar;%APP_HOME%\lib\jackson-databind-2.4.6.jar;%APP_HOME%\lib\hibernate-validator-5.1.3.Final.jar;%APP_HOME%\lib\spring-web-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-webmvc-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-1.2.4.RELEASE.jar;%APP_HOME%\lib\spring-cloud-netflix-hystrix-dashboard-1.0.3.RELEASE.jar;%APP_HOME%\lib\jetty-jsp-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-webapp-9.2.10.v20150310.jar;%APP_HOME%\lib\websocket-server-9.2.10.v20150310.jar;%APP_HOME%\lib\javax-websocket-server-impl-9.2.10.v20150310.jar;%APP_HOME%\lib\metrics-core-2.2.0.jar;%APP_HOME%\lib\scala-library-2.10.4.jar;%APP_HOME%\lib\kafka-clients-0.8.2.1.jar;%APP_HOME%\lib\zookeeper-3.4.6.jar;%APP_HOME%\lib\jopt-simple-3.2.jar;%APP_HOME%\lib\zkclient-0.3.jar;%APP_HOME%\lib\avro-compiler-1.7.6.jar;%APP_HOME%\lib\avro-1.7.6.jar;%APP_HOME%\lib\spring-integration-core-4.1.4.RELEASE.jar;%APP_HOME%\lib\metrics-annotation-2.2.0.jar;%APP_HOME%\lib\feign-core-8.1.1.jar;%APP_HOME%\lib\slf4j-api-1.7.12.jar;%APP_HOME%\lib\spring-cloud-context-1.0.2.RELEASE.jar;%APP_HOME%\lib\spring-cloud-commons-1.0.2.RELEASE.jar;%APP_HOME%\lib\archaius-core-0.6.5.jar;%APP_HOME%\lib\rxjava-1.0.11.jar;%APP_HOME%\lib\jackson-core-2.4.6.jar;%APP_HOME%\lib\aspectjweaver-1.8.5.jar;%APP_HOME%\lib\aspectjrt-1.8.5.jar;%APP_HOME%\lib\guava-18.0.jar;%APP_HOME%\lib\commons-collections-3.2.1.jar;%APP_HOME%\lib\commons-lang3-3.1.jar;%APP_HOME%\lib\jsr305-2.0.0.jar;%APP_HOME%\lib\spring-beans-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-context-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-expression-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-data-commons-1.9.2.RELEASE.jar;%APP_HOME%\lib\jcl-over-slf4j-1.7.12.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.12.jar;%APP_HOME%\lib\logback-classic-1.1.3.jar;%APP_HOME%\lib\jackson-annotations-2.4.6.jar;%APP_HOME%\lib\validation-api-1.1.0.Final.jar;%APP_HOME%\lib\jboss-logging-3.1.3.GA.jar;%APP_HOME%\lib\classmate-1.0.0.jar;%APP_HOME%\lib\spring-aop-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-freemarker-1.2.4.RELEASE.jar;%APP_HOME%\lib\httpclient-4.3.6.jar;%APP_HOME%\lib\jquery-2.1.1.jar;%APP_HOME%\lib\d3js-3.4.11.jar;%APP_HOME%\lib\jetty-schemas-3.1.M0.jar;%APP_HOME%\lib\javax.servlet-api-3.1.0.jar;%APP_HOME%\lib\javax.servlet.jsp-api-2.3.1.jar;%APP_HOME%\lib\javax.servlet.jsp-2.3.2.jar;%APP_HOME%\lib\javax.servlet.jsp.jstl-1.2.0.v201105211821.jar;%APP_HOME%\lib\javax.servlet.jsp.jstl-1.2.2.jar;%APP_HOME%\lib\javax.el-3.0.0.jar;%APP_HOME%\lib\org.eclipse.jdt.core-3.8.2.v20130121.jar;%APP_HOME%\lib\jetty-xml-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-servlet-9.2.10.v20150310.jar;%APP_HOME%\lib\websocket-common-9.2.10.v20150310.jar;%APP_HOME%\lib\websocket-client-9.2.10.v20150310.jar;%APP_HOME%\lib\websocket-servlet-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-http-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-annotations-9.2.10.v20150310.jar;%APP_HOME%\lib\javax-websocket-client-impl-9.2.10.v20150310.jar;%APP_HOME%\lib\javax.websocket-api-1.0.jar;%APP_HOME%\lib\lz4-1.2.0.jar;%APP_HOME%\lib\snappy-java-1.1.1.6.jar;%APP_HOME%\lib\log4j-1.2.17.jar;%APP_HOME%\lib\jline-0.9.94.jar;%APP_HOME%\lib\netty-3.7.0.Final.jar;%APP_HOME%\lib\commons-lang-2.6.jar;%APP_HOME%\lib\velocity-1.7.jar;%APP_HOME%\lib\jackson-core-asl-1.9.13.jar;%APP_HOME%\lib\jackson-mapper-asl-1.9.13.jar;%APP_HOME%\lib\paranamer-2.3.jar;%APP_HOME%\lib\commons-compress-1.4.1.jar;%APP_HOME%\lib\reactor-core-1.1.6.RELEASE.jar;%APP_HOME%\lib\spring-messaging-4.1.6.RELEASE.jar;%APP_HOME%\lib\spring-retry-1.1.2.RELEASE.jar;%APP_HOME%\lib\spring-security-crypto-3.2.7.RELEASE.jar;%APP_HOME%\lib\commons-configuration-1.8.jar;%APP_HOME%\lib\annotations-2.0.0.jar;%APP_HOME%\lib\logback-core-1.1.3.jar;%APP_HOME%\lib\aopalliance-1.0.jar;%APP_HOME%\lib\freemarker-2.3.22.jar;%APP_HOME%\lib\spring-context-support-4.1.6.RELEASE.jar;%APP_HOME%\lib\httpcore-4.3.3.jar;%APP_HOME%\lib\commons-codec-1.6.jar;%APP_HOME%\lib\jetty-util-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-security-9.2.10.v20150310.jar;%APP_HOME%\lib\websocket-api-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-io-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-plus-9.2.10.v20150310.jar;%APP_HOME%\lib\javax.annotation-api-1.2.jar;%APP_HOME%\lib\asm-5.0.1.jar;%APP_HOME%\lib\asm-commons-5.0.1.jar;%APP_HOME%\lib\xz-1.0.jar;%APP_HOME%\lib\disruptor-3.2.1.jar;%APP_HOME%\lib\jsr166e-1.0.jar;%APP_HOME%\lib\jetty-server-9.2.10.v20150310.jar;%APP_HOME%\lib\jetty-jndi-9.2.10.v20150310.jar;%APP_HOME%\lib\asm-tree-5.0.1.jar;%APP_HOME%\lib\junit-4.12.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\gs-collections-5.1.0.jar;%APP_HOME%\lib\gs-collections-api-5.1.0.jar

@rem Execute event_hub
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %EVENT_HUB_OPTS%  -classpath "%CLASSPATH%" com.afm.EventHub %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable EVENT_HUB_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%EVENT_HUB_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
