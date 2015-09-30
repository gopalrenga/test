Ext
		.onReady(function() {

			var login = new Ext.FormPanel(
					{
						layout : 'form',
						id : 'loginForm',
						items : [
								{
									xtype : 'label',
									text : 'Username:',
								},
								{
									name : 'loginUsername',
									xtype : 'textfield',
									allowBlank : false,
									autoHeight : true
								},
								{
									xtype : 'label',
									text : 'Password:',
								},
								{
									name : 'loginPassword',
									xtype : 'textfield',
									inputType : 'password',
									allowBlank : false,
									autoHeight : true
								},
								{
									xtype : 'button',
									name : 'login',
									text : 'Log In',
									formBind : true,
									handler : function() {
										var form = this.up('form').getForm();
										var values = form.getValues();
										Ext.Ajax
												.request({
													url : 'login',
													method : 'POST',
													jsonData : {
														userName : values["loginUsername"],
														password : values["loginPassword"]
													},
													success : function(response) {
														responseText = eval('('
																+ response.responseText
																+ ')');
														if (responseText.loginStatus == "success") {
															viewPort
																	.remove(login);
															viewPort
																	.add(mainPanel);
														} else {
															Ext.Msg
																	.alert(
																			'Status',
																			'Login faiure due to invalid credentials.');
														}
													},
													failure : function(response) {
														Ext.Msg.alert('Status',
																'Login failed');
													}

												});
									}
								} ],
					});
			
			var createPanel = Ext.create('Ext.form.Panel', {
				layout : 'form',
				id : 'createForm',
				title : 'Create',
				items : [ {
					xtype : 'label',
					text : 'Title:',
				}, {
					xtype : 'textfield',
					allowBlank : false,
					name : 'title'
				}, {
					xtype : 'label',
					text : 'Query:',
				}, {
					xtype : 'textarea',
					allowBlank : false,
					name : 'query'
				}, {
					xtype : 'label',
					text : 'Tag:',
				}, {
					xtype : 'textfield',
					allowBlank : false,
					name : 'tag'
				}, {
					xtype : 'button',
					name : 'Create_Query',
					text : 'Create Query',
					formBind : true,
					handler : function() {
					}
				} ]
			});


			var tabPanel = Ext.create('Ext.tab.Panel', {
				width : 800,
				height : 800,
				layout:'fit',
				activeTab:0,
				items : [ createPanel ]

			});

			
			var mainPanel = Ext.create('Ext.panel.Panel', {
				layout : 'border',
				region : 'center',
				width : '100%',
				height : '100%',
				items : [ tabPanel ]
			});

			var viewPort = Ext.create('Ext.container.Viewport', {
				layout : 'border',
				detachOnRemove : true,
				height : '100%',
				items : [ login ]
			});

		});
