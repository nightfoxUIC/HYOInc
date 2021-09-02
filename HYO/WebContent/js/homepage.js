var homeApp = angular.module('homeApp', ['ngMaterial', 'ngMessages']);


homeApp.controller('AppCtrl', function ($scope, $timeout, $mdSidenav, $log, $http) {
  var vm = this;
  vm.selectedPage = 'html/items/searchProducts.html';
  vm.searchKey="";
  vm.items=[];
  vm.addItem={};
  vm.editItem={};
  vm.itemList=[];
  vm.stockQtyList=[];
  vm.supplierList =[];
  vm.manufacturerList = [];
  vm.locationList = [];
  vm.itemTypeList = [];
  
  vm.menuMap={
			"SP":"Inventory",
			"SA":"Stock Quantity Alert",
			"SU":"Supplier",
			"MU":"Manufacturer",
			"LO":"Location",
			"IT":"Item Type",
			"AU":"About Us",
			"CU":"Contact Us"
	}
  var month = new Array();
  month[0] = "Jan";
  month[1] = "Feb";
  month[2] = "Mar";
  month[3] = "Apr";
  month[4] = "May";
  month[5] = "Jun";
  month[6] = "Jul";
  month[7] = "Aug";
  month[8] = "Sep";
  month[9] = "Oct";
  month[10] = "Nov";
  month[11] = "Dec ";
 function loadDetails(){
	  $http({
	      method :'GET',
	      url : 'loadAll',
	      data : $scope.user,
	      headers: {
	          'Content-Type': 'application/json'
	      }
	  }).then(function (response){
		 vm.allDetailsMap = response.data;
		 vm.itemList = vm.allDetailsMap['items'];
		 vm.supplierList = vm.allDetailsMap['suppliers'];
		 vm.manufacturerList = vm.allDetailsMap['manufacturers'];
		 vm.locationList = vm.allDetailsMap['locations'];
		 vm.itemTypeList = vm.allDetailsMap['itemTypes'];
	   },function (error){
		  console.log(error.data);
	   });
}
loadDetails();

vm.navigateToPage = function(pageKey,selected){
	  switch(pageKey) {
	  case "SP":
		  vm.selectedPage = 'html/items/searchProducts.html'
	    break;
	  case "SA":
		  var stockAlertList=[];
		  angular.forEach(vm.allDetailsMap['items'],function(item){
			  if(item.stockQty<=20)stockAlertList.push(item);
		  });
		  vm.allDetailsMap['stockAlertItems'] = stockAlertList;
		  vm.stockQtyList=stockAlertList;
		  vm.selectedPage = 'html/stockQtyAlert/stockQtyAlert.html'
		  	break;
	  case "SU":
		  vm.selectedPage = 'html/suppliers/suppliers.html';
		    break;
	  case "MU":
		  vm.selectedPage = 'html/manufacturers/manufacturers.html';
		    break;
	  case "LO":
		  vm.selectedPage = 'html/locations/locations.html';
		    break;
	  case "IT":
		  vm.selectedPage = 'html/itemTypes/itemTypes.html';
		    break;
	  case "AU":
		  vm.selectedPage = 'html/aboutUs/aboutUs.html';
		    break;
	  case "CU":
		  vm.selectedPage = 'html/contactUs/contactUs.html';
		    break;
	  case "AI":
		  vm.selectedPage = 'html/items/addItem.html';
		    break;
	  case "EI":
		  vm.editItem = selected;
		  vm.selectedPage = 'html/items/editItem.html';
		    break;
	  case "ASU":
		  vm.selectedPage = 'html/suppliers/addSupplier.html';
		  break;
	  case "ESU":
		  vm.editSupplier = selected;
		  vm.selectedPage = 'html/suppliers/editSupplier.html';
		    break;
	  case "AMU":
		  vm.selectedPage = 'html/manufacturers/addManufacturer.html';
		  break;
	  case "EMU":
		  vm.editManufacturer = selected;
		  vm.selectedPage = 'html/manufacturers/editManufacturer.html';
		  break;
	  case "ALO":
		  vm.selectedPage = 'html/locations/addLocation.html';
		  break;
	  case "ELO":
		  vm.editLocation = selected;
		  vm.selectedPage = 'html/locations/editLocation.html';
		  break;
	  case "AIT":
		  vm.selectedPage = 'html/itemTypes/addItemType.html';
		  break;
	  case "EIT":
		  vm.editItemType = selected;
		  vm.selectedPage = 'html/itemTypes/editItemType.html';
		    break;
	  default:
		  	// code block
	}
  }
vm.searchItem = function(){
	var searchWord = vm.searchKey.toUpperCase();
	if(searchWord ==null || searchWord.trim()=="" || searchWord.length==0) {
		vm.itemList = vm.allDetailsMap['items'];
		return;
	}
	vm.itemList=[];
	vm.itemListLength= vm.allDetailsMap['items'].length;
	var tempList= vm.allDetailsMap['items'];
	for(i=0;i<tempList.length;i++) {	
		if(tempList[i].productID.toUpperCase().includes(searchWord) ||
			 tempList[i].product.toUpperCase().includes(searchWord) ||
			 tempList[i].model.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].manufacturerCode.toUpperCase().includes(searchWord) ||
			 tempList[i].supplierCode.toUpperCase().includes(searchWord) ||
			 tempList[i].itemTypeCode.toUpperCase().includes(searchWord) ||
			 tempList[i].locationCode.toUpperCase().includes(searchWord) ||
			 tempList[i].MSRP.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].unitCost.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].discountRate.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].stockQty.toString().toUpperCase().includes(searchWord)) vm.itemList.push(tempList[i]);
	};
}

vm.searchStockQtyItem = function(){
	var searchWord = vm.searchKeyStockQty.toUpperCase();
	if(searchWord==null || searchWord.trim()=="" || searchWord.length==0) {
		vm.stockQtyList = vm.allDetailsMap['stockAlertItems'];
		return;
	}
	vm.stockQtyList=[];
	vm.stockQtyListLength= vm.allDetailsMap['stockAlertItems'].length;
	var tempList= vm.allDetailsMap['stockAlertItems'];
	for(i=0;i<tempList.length;i++) {	
		if(tempList[i].productID.toUpperCase().includes(searchWord) ||
			 tempList[i].product.toUpperCase().includes(searchWord) ||
			 tempList[i].model.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].manufacturerCode.toUpperCase().includes(searchWord) ||
			 tempList[i].supplierCode.toUpperCase().includes(searchWord) ||
			 tempList[i].itemTypeCode.toUpperCase().includes(searchWord) ||
			 tempList[i].locationCode.toUpperCase().includes(searchWord) ||
			 tempList[i].MSRP.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].unitCost.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].discountRate.toString().toUpperCase().includes(searchWord) ||
			 tempList[i].stockQty.toString().toUpperCase().includes(searchWord)) vm.stockQtyList.push(tempList[i]);
	};
}

vm.searchOther = function(key){
	var searchWord = vm.searchOtherKey.toUpperCase();
	if(searchWord==null || searchWord.trim()=="" || searchWord.length==0) {
		if(key == 'suppliers'){
			vm.supplierList = vm.allDetailsMap[key];
		}else if(key == 'manufacturers'){
			vm.manufacturerList = vm.allDetailsMap[key];
		}else if(key == 'locations'){
			vm.locationList = vm.allDetailsMap[key];
		}else{
			vm.itemTypeList = vm.allDetailsMap[key];
		}
		return;
	}
	
	if(key == 'suppliers'){
		vm.supplierList =[];
	}else if(key == 'manufacturers'){
		vm.manufacturerList = [];
	}else if(key == 'locations'){
		vm.locationList = [];
	}else{
		vm.itemTypeList = [];
	}
	
	vm.stockQtyListLength= vm.allDetailsMap['stockAlertItems'].length;
	var tempList= vm.allDetailsMap[key];
	for(i=0;i<tempList.length;i++) {	
		if(tempList[i].code.toUpperCase().includes(searchWord) ||
			 tempList[i].name.toUpperCase().includes(searchWord) ) {
				if(key == 'suppliers'){
					vm.supplierList.push(tempList[i]);
				}else if(key == 'manufacturers'){
					vm.manufacturerList.push(tempList[i]);
				}else if(key == 'locations'){
					vm.locationList.push(tempList[i]);
				}else{
					vm.itemTypeList.push(tempList[i]);
				}
		}
				
	};
}

vm.deleteItem = function(){
	var conf = confirm("Are you sure you want to delete?");
	if(conf){
		angular.forEach(vm.itemList,function(item,index){
			if(item.productID == vm.editItem.productID){
				vm.itemList.splice(index,1);
			}
		});
		vm.navigateToPage('SP');
		vm.editItem = {};
		alert("Deleted Successfully");
	}
}
vm.deleteOther = function(pageKey,key,object){
	var conf = confirm("Are you sure you want to delete?");
	if(conf){
		if(key == 'suppliers'){
			angular.forEach(vm.supplierList,function(listObj,index){
				if(listObj.code == object.code){
					vm.supplierList.splice(index,1);
				}
			});
			vm.editsupplier={};
		}else if(key == 'manufacturers'){
			angular.forEach(vm.manufacturerList,function(listObj,index){
				if(listObj.code == object.code){
					vm.manufacturerList.splice(index,1);
				}
			});
			vm.editManufacturer={};
		}else if(key == 'locations'){
			angular.forEach(vm.locationList,function(listObj,index){
				if(listObj.code == object.code){
					vm.locationList.splice(index,1);
				}
			});
			vm.editLocation={};
		}else{
			angular.forEach(vm.itemTypeList,function(listObj,index){
				if(listObj.code == object.code){
					vm.itemTypeList.splice(index,1);
				}
			});
			vm.editItemType = {};
		}
		vm.navigateToPage(pageKey);
		alert("Deleted Successfully");
	}
}

vm.saveItem= function(){
	vm.itemList = vm.allDetailsMap['items'];
	vm.addItem.lastUpdated = month[vm.addItem.lastUpdated.getMonth()]+' '+ vm.addItem.lastUpdated.getDay()+', '+vm.addItem.lastUpdated.getFullYear();
	vm.itemList.push(vm.addItem);
	vm.allDetailsMap['items'] = vm.itemList;
	vm.navigateToPage('SP');
	vm.addItem = {};
	alert("Added Successfully");
}
vm.saveOther= function(pageKey,key,object){
	if(key == 'suppliers'){
		vm.supplierList = vm.allDetailsMap[key];
		vm.supplierList.push(object);
		vm.allDetailsMap['suppliers'] = vm.supplierList;
		vm.addSupplier={};
	}else if(key == 'manufacturers'){
		vm.manufacturerList = vm.allDetailsMap[key];
		vm.manufacturerList.push(object);
		vm.allDetailsMap['manufacturers'] = vm.manufacturerList;
		vm.addManufacturer={};
	}else if(key == 'locations'){
		vm.locationList = vm.allDetailsMap[key];
		vm.locationList.push(object);
		vm.allDetailsMap['locations'] = vm.locationList;
		vm.addLocation={};
	}else{
		vm.itemTypeList = vm.allDetailsMap[key];
		vm.itemTypeList.push(object);
		vm.allDetailsMap['itemTypes'] = vm.itemTypeList;
		vm.addItemType={};
	}
	vm.navigateToPage(pageKey);
	alert("Added Successfully");
}

vm.updateItem= function(){
	angular.forEach(vm.itemList,function(item,index){
		if(item.productID == vm.editItem.productID){
			vm.itemList.splice(index,1);
			vm.itemList.push(vm.editItem);
		}
	});
	vm.navigateToPage('SP');
	vm.editItem = {};
	alert("Updated Successfully");
}

vm.updateOther= function(pageKey,key,object){
	if(key == 'suppliers'){
		angular.forEach(vm.supplierList,function(listObj,index){
			if(listObj.code == object.code){
				vm.supplierList.splice(index,1);
				vm.supplierList.push(object);
			}
		});
		vm.editsupplier={};
	}else if(key == 'manufacturers'){
		angular.forEach(vm.manufacturerList,function(listObj,index){
			if(listObj.code == object.code){
				vm.manufacturerList.splice(index,1);
				vm.manufacturerList.push(object);
			}
		});
		vm.editManufacturer={};
	}else if(key == 'locations'){
		angular.forEach(vm.locationList,function(listObj,index){
			if(listObj.code == object.code){
				vm.locationList.splice(index,1);
				vm.locationList.push(object);
			}
		});
		vm.editLocation={};
	}else{
		angular.forEach(vm.itemTypeList,function(listObj,index){
			if(listObj.code == object.code){
				vm.itemTypeList.splice(index,1);
				vm.itemTypeList.push(object);
			}
		});
		vm.editItemType={};
	}
	vm.navigateToPage(pageKey);
	vm.editItem={};
	alert("Updated Successfully");
}



$scope.toggleLeft = buildDelayedToggler('left');
$scope.toggleRight = buildToggler('right');
$scope.isOpenRight = function(){
  return $mdSidenav('right').isOpen();
};
  /**
   * Supplies a function that will continue to operate until the
   * time is up.
   */
  function debounce(func, wait, context) {
    var timer;

    return function debounced() {
      var context = $scope,
          args = Array.prototype.slice.call(arguments);
      $timeout.cancel(timer);
      timer = $timeout(function() {
        timer = undefined;
        func.apply(context, args);
      }, wait || 10);
    };
  }

  /**
   * Build handler to open/close a SideNav; when animation finishes
   * report completion in console
   */
  function buildDelayedToggler(navID) {
    return debounce(function() {
      // Component lookup should always be available since we are not using `ng-if`
      $mdSidenav(navID)
        .toggle()
        .then(function () {
          $log.debug("toggle " + navID + " is done");
        });
    }, 200);
  }

  function buildToggler(navID) {
    return function() {
      // Component lookup should always be available since we are not using `ng-if`
      $mdSidenav(navID)
        .toggle()
        .then(function () {
          $log.debug("toggle " + navID + " is done");
        });
    };
  }
})
.controller('LeftCtrl', function ($scope, $timeout, $mdSidenav, $log) {
  $scope.close = function () {
    // Component lookup should always be available since we are not using `ng-if`
    $mdSidenav('left').close()
      .then(function () {
        $log.debug("close LEFT is done");
      });

  };
})
.controller('RightCtrl', function ($scope, $timeout, $mdSidenav, $log) {
  $scope.close = function () {
    // Component lookup should always be available since we are not using `ng-if`
    $mdSidenav('right').close()
      .then(function () {
        $log.debug("close RIGHT is done");
      });
  };
});
