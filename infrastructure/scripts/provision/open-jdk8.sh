echo "=====> Installing openjdk-8"
sudo apt-get --yes install software-properties-common
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get --yes install openjdk-8-jdk