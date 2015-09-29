Ext.application({
        name:'HelloWorld',
        launch:function(){
        	alert();
            console.log('App created');

var login = new Ext.FormPanel({
  labelWidth: 80,
  //bodyStyle: "background-image:url('/images/logon.jpg')",
  layout: 'absolute',
  id: 'loginForm',
  items:[{
	   xtype: 'label',
	   style: 'color: #FFF; font-weight: bold; font-size: 11px',
	   text: 'Username:',
	   x: 165,
	   y: 80,
	}, {
	   name: 'loginUsername',
	   xtype:'textfield',
	   allowBlank: false,
	   x: 160,
	   y: 98,
	   style: 'font-size: 20px',
	   autoHeight: true
	},{
		   xtype: 'label',
		   style: 'color: #FFF; font-weight: bold; font-size: 11px',
		   text: 'Password:',
		   x: 165,
		   y: 80,
		}, {
		   name: 'loginPassword',
		   xtype:'textfield',
		   allowBlank: false,
		   x: 160,
		   y: 98,
		   style: 'font-size: 20px',
		   autoHeight: true
		}, {
			  xtype: 'button',
			  name: 'login',
			  text: 'Log In',
			  width: 80,
			  x: 290,
			  y: 210,
			  formBind: true,
			  handler: function() {
			    alert("login");			  }
			} ],
});

var win = new Ext.Window({
	  layout:'fit',
	  closable: false,
	  draggable: false,
	  resizable: false,
	  width: 425,
	  plain: true,
	  border: false,
	  bbar: [{
	    xtype: 'tbtext',
	    text: ' ©    2011 - present. iTrinegy'
	  }],
	  items: [ login ]
	});

Ext.create('Ext.container.Viewport',{
    layout:'fit',
    items:{
    	title: 'This is how a title looks like',
        html: 'Hello Extjs'
    }
});
}
});