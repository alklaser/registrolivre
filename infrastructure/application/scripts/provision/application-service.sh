#!/bin/sh
### BEGIN INIT INFO
# Provides:          registrolivre
# Required-Start:    $local_fs $remote_fs $network $syslog
# Required-Stop:     $local_fs $remote_fs $network $syslog
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# X-Interactive:     true
# Short-Description: Start/stop/Restart registrolivre server
### END INIT INFO

case $1 in
    start)
        echo "Starting registrolivre service ..."
        if [ ! -f /home/registrolivre/app/pid ]; then
            nohup java -Dserver.port=5000 -jar /home/registrolivre/app/registrolivre.jar /home/registrolivre/app 2>> /home/registrolivre/app/logs.txt >> /home/registrolivre/app/logs.txt &
            echo $! > /home/registrolivre/app/pid
            echo "registrolivre service started ..."
        else
            echo "registrolivre service is already running ..."
        fi
    ;;
    stop)
        if [ -f /home/registrolivre/app/pid ]; then
            PID=$(cat /home/registrolivre/app/pid);
            echo "Stopping registrolivre service ..."
            kill $PID;
            echo "registrolivre service stopped ..."
            rm /home/registrolivre/app/pid
        else
            echo "registrolivre service is not running ..."
        fi
    ;;
    restart)
        if [ -f /home/registrolivre/app/pid ]; then
            PID=$(cat /home/registrolivre/app/pid);
            echo "Stopping registrolivre service ...";
            kill $PID;
            echo "registrolivre service stopped ...";
            rm /home/registrolivre/app/pid

            echo "Starting registrolivre service ..."
            nohup java -Dserver.port=5000 -jar /home/registrolivre/app/registrolivre.jar /home/registrolivre/app 2>> /home/registrolivre/app/logs.txt >> /home/registrolivre/app/logs.txt &
            echo $! > /home/registrolivre/app/pid
            echo "registrolivre service started ..."
        else
            echo "registrolivre service is not running ..."
        fi
    ;;
esac