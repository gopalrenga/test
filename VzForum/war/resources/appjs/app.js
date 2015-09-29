Ext.onReady(function() {

	var login = new Ext.FormPanel({
		layout : 'form',
		id : 'loginForm',
		items : [ {
			xtype : 'label',
			text : 'Username:',
		}, {
			name : 'loginUsername',
			xtype : 'textfield',
			allowBlank : false,
			autoHeight : true
		}, {
			xtype : 'label',
			text : 'Password:',
		}, {
			name : 'loginPassword',
			xtype : 'textfield',
			inputType: 'password',
			allowBlank : false,
			autoHeight : true
		}, {
			xtype : 'button',
			name : 'login',
			text : 'Log In',
			formBind : true,
			handler : function() {
				
			}
		} ],
	});
	Ext.create('Ext.container.Viewport', {
		layout : 'border',
		items : [ login ]
	});

});






