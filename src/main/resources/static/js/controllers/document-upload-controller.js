app.controller("DocumentUploadController", ["$scope", "documentUpload", function($scope, documentUpload) {
    $scope.document = null;
    $scope.uploadDocument = function() {
        documentUpload.sendDocument();
    };
}]);