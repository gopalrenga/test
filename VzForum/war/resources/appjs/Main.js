/**
 * 
 */

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

			
			var leftPanel = Ext.create('Ext.Panel', {
		        width    : 500,
		        height   : 250,
		        style    : 'margin-top:15px',
		        bodyStyle: 'padding:10px',
		        autoScroll: true,
		        lbar: [{
	                iconCls: 'home-icon',
	                tooltip: 'Button 1',
	                xtype: 'button',
	                width:100,
	                height:100,
	                scale:'large',
	                iconAlign:'left'
	            },{
	                iconCls: 'home-icon',
	                tooltip: 'Button 1'
	            }
	            
	        ]

		        
		    });



			var tabPanel = Ext.create('Ext.tab.Panel', {
				width : 800,
				height : 800,
				layout:'xbox',
				activeTab:0,
				items : [ createPanel ]

			});

			
			var mainPanel = Ext.create('Ext.panel.Panel', {
				layout : 'border',
				region : 'center',
				width : '100%',
				height : '100%',
				items : [ leftPanel ]
			});