# swagger2得到接口信息

### 方法：
可行的:

        @RequestMapping(value = "/getAllURL", method = RequestMethod.POST)
        @ApiOperation("查询项目中所有接口信息")
        public void getAllURL() {
        List<Map<String, String>> resultList = new ArrayList<>();
		RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
		// 获取url与类和方法的对应信息
		Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();

		for (Map.Entry<RequestMappingInfo, HandlerMethod> mappingInfoHandlerMethodEntry : map.entrySet()) {
			Map<String, String> resultMap = new LinkedHashMap<>();

			RequestMappingInfo requestMappingInfo = mappingInfoHandlerMethodEntry.getKey();
			HandlerMethod handlerMethod = mappingInfoHandlerMethodEntry.getValue();

			resultMap.put("className",handlerMethod.getMethod().getDeclaringClass().getName()); // 类名
			Annotation[] parentAnnotations = handlerMethod.getBeanType().getAnnotations();
			for (Annotation annotation : parentAnnotations) {
				if (annotation instanceof Api) {
					Api api = (Api) annotation;
					resultMap.put("classDesc",api.value());
				} else if (annotation instanceof RequestMapping) {
					RequestMapping requestMapping = (RequestMapping) annotation;
					if (null != requestMapping.value() && requestMapping.value().length > 0) {
						resultMap.put("classURL",requestMapping.value()[0]);//类URL
					}
				}
			}
			resultMap.put("methodName", handlerMethod.getMethod().getName()); // 方法名
			Annotation[] annotations = handlerMethod.getMethod().getDeclaredAnnotations();
			if (annotations != null) {
				// 处理具体的方法信息
				for (Annotation annotation : annotations) {
					if (annotation instanceof ApiOperation) {
						ApiOperation methodDesc = (ApiOperation) annotation;
						String desc = methodDesc.value();
						resultMap.put("methodDesc",desc);//接口描述
					}
				}
			}
			PatternsRequestCondition p = requestMappingInfo.getPatternsCondition();
			for (String url : p.getPatterns()) {
				resultMap.put("methodURL",url);//请求URL
			}
			RequestMethodsRequestCondition methodsCondition = requestMappingInfo.getMethodsCondition();
			for (RequestMethod requestMethod : methodsCondition.getMethods()) {
				resultMap.put("requestType",requestMethod.toString());//请求方式：POST/PUT/GET/DELETE
			}
			resultList.add(resultMap);
		}
		for (Map<String, String> map1:resultList) {
			if(!map1.get("methodURL").isEmpty()){
				// 插入数据库
    //				userMapper.insertUrl(map1.get("methodURL"),map1.get("methodDesc"));
    }
    }
    //		return JSONArray.fromObject(resultList);
    }
