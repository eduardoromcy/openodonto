<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@ taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OpenOdonto - Cadastro de Usuarios</title>
<script type="text/javascript" src="/openodonto/js/jquery.maskedinput-1.1.4.pack.js"></script>
<script type="text/javascript">
function exibirMensagem(msg){
	alert(msg);
}
</script>
</head>
<body style="background-color: #fafbfc !important;">
<f:view>
<a4j:keepAlive beanName="manterUsuario"/>
<a4j:region id="rb">
<jsp:include page="/cabecalho.jsp" />
<jsp:include page="/Loading.jsp" />
<a4j:form ajaxSubmit="true" id="formUsuario">
<a4j:jsFunction name="popUp" action="#{manterUsuario.acaoShowed}" oncomplete="exibirMensagem('#{manterDentista.view.popUpMsg}')"/>
	<h:panelGrid>
		<rich:message id="output" for="output" style=" width : 100%;"/>
	</h:panelGrid>	
	<rich:panel style="background-color : transparent">
			<f:facet name="header">
				<h:outputText value="Cadastro de Usuarios" style="COLOR : white" />
			</f:facet>
							
			<center>
			<rich:panel style="width : 90%; text-align:left;" >				
				<center>
				<h:panelGrid columns="1">			
			
			<h:panelGrid columns="2">
				<h:panelGrid columns="1">
					<h:outputLabel value="Codigo" for="codigoDentista" />
					<h:inputText id="codigoDentista" readonly="true" disabled="true" value="#{manterUsuario.usuario.codigo}" style=" width : 160px;" />
				</h:panelGrid>

				<h:panelGrid columns="1">
				    <h:panelGrid columns="3">				
					    <h:outputLabel value="Nome" for="entradaNome"  style="color : red" />
	                    <rich:spacer width="8" />
	                    <rich:message id="messageEntradaNome" for="entradaNome" style="color : red ;FONT-WEIGHT : bold" />
	                </h:panelGrid>
					<h:inputText id="entradaNome" value="#{manterUsuario.usuario.nome}" style="width : 310px;"	/>
				</h:panelGrid>

           
				<h:panelGrid columns="1">
				    <h:panelGrid columns="3">				
					    <h:outputLabel value="Usuario" for="entradaUser" style="color : red"/>
	                    <rich:spacer width="8" />
	                    <rich:message id="messageEntradaUser" for="entradaUser" style="color : red ;FONT-WEIGHT : bold" />
	                </h:panelGrid>
					<h:inputText value="#{manterUsuario.usuario.user}"  id="entradaUser" style="width : 160px;"/>
				</h:panelGrid>
				
				<h:panelGrid columns="1">
				    <h:panelGrid columns="3">				
					    <h:outputLabel value="Senha" style="color : red" for="entradaSenha" />
	                    <rich:spacer width="8" />
	                    <rich:message id="messageEntradaSenha" for="entradaSenha" style="color : red ;FONT-WEIGHT : bold" />
	                </h:panelGrid>
	                <h:panelGrid columns="3">
					    <h:inputSecret disabled="#{manterUsuario.enableChangePassword}" valueChangeListener="#{manterUsuario.changePassword}" id="entradaSenha" value="#{manterUsuario.usuario.senha}" style=" width : 280px;" />
					    <h:commandButton disabled="#{not manterUsuario.enableChangePassword}" value="Alterar" image="/helt/edit-19x19.jpg">
					        <rich:toolTip value="Editar" />
					    </h:commandButton>
					</h:panelGrid>
				</h:panelGrid>
				
			</h:panelGrid>
			
			
			</h:panelGrid>
				</center>
			</rich:panel>
			</center>			
		</rich:panel>

			<rich:spacer height="16"/>	
			<center>			
            <h:panelGroup>
				<a4j:commandButton id="botaoSalvar" image="/helt/salvar.png" oncomplete="if(#{manterUsuario.view.displayPopUp}){popUp()}" action="#{manterUsuario.acaoAlterar}" value="salvar" reRender="formUsuario" focus="output" />
				<rich:spacer width="16"/>
				<a4j:commandButton image="/helt/pesquisar.png" id="botaoBuscar" onclick="#{rich:component('painelBuscaUsuario')}.show()" reRender="formModalUsuario"/>
				<rich:spacer width="16"/>
				<a4j:commandButton image="/helt/excluir.png" id="botaoExcluir"  action="#{manterUsuario.acaoRemoverSim}" onclick="if(!confirm('Deseja realmente excluir o registro ?')){return false}" reRender="formUsuario" oncomplete="if(#{manterUsuario.view.displayPopUp}){popUp()}" />
				<rich:spacer width="16"/>
				<a4j:commandButton image="/helt/cancelar.png"  action="#{manterUsuario.acaoAtualizar}" reRender="formUsuario" />												
            </h:panelGroup>			
			</center>

	</a4j:form>
	
	<jsp:include page="/footer.jsp" />
   <jsp:include page="modalBuscarUsuario.jsp" />
	
	</a4j:region>
	

</f:view>
</body>
</html>