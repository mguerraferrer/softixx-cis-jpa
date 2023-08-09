package mx.lkmsoft.cis.jpa.pageable;

/**
 * @author Maikel Guerra Ferrer
 *
 */
final class PageableConstants {
	
	/*
	pageable.text.info.showing.records=Mostrando {0}-{1} de {2} registros
	pageable.text.info.no.records=No existe información a mostrar
	pageable.text.info.paginate.result=Mostrando {0,choice,0#registros|1#1 registro|1<{0,number,integer} registros}
	pageable.text.sort.by.required=El parámetro SortBy no debe ser nulo
	pageable.text.sort.request.required=El parámetro SortRequest no debe ser nulo
	pageable.text.sort.request.list.required=El parámetro SortRequests debe contener elementos no nulos
	pageable.text.page.required=El parámetro Page no debe ser nulo
	pageable.text.page.data.required=Los datos de la página no deben ser nulos
	pageable.text.page.number.invalid=El número de página debe ser mayor que 0
	pageable.text.page.size.invalid=El tamaño de la página debe ser mayor que 0
	pageable.text.page.key.requeired=El parámetro Key no debe ser nulo
	pageable.text.pageable.requeired=El parámetro Pageable no debe ser nulo
	pageable.text.records.per.page.invalid=Los registros por página deben ser mayores que 0
	pageable.text.paginate.page.required=Los registros por página no deben ser nulos
	pageable.text.records.per.page.pages.to.display.invalid=Es necesario especificar un valor para el parámetro recordsPerPage o pagesToDisplay
	pageable.text.records.per.page.nullable.list=La lista de registros por página no debe ser nula
	pageable.text.records.per.page.empty.list=La lista de registros por página no debe estar vacía
	pageable.text.paginate.page.required=Las páginas paginadas no deben ser nulas
	pageable.text.paginate.page.invalid=Las páginas paginadas deben ser mayores que 0
	pageable.text.parameter.empty.value=Debe especificarse un valor para al menos un parámetro
	*/
	
	private PageableConstants() {		
	}
	
	public static final String PAGE_NUMBER_INVALID = "El número de página debe ser mayor que 0";
	
	public static final String PAGE_SIZE_INVALID = "El tamaño de la página debe ser mayor que 0";
	
	public static final String KEY_PARAM_REQUIRED = "El parámetro Key no debe ser nulo";
	
	public static final String PAGEABLE_PARAM_REQUIRED = "El parámetro Pageable no debe ser nulo";
	
	public static final String SORT_BY_ASSERT_MESSAGE = "El parámetro SortBy no debe ser nulo";
	
	public static final String SORT_REQUEST_ASSERT_MESSAGE = "El parámetro SortRequest no debe ser nulo";
	
	public static final String SORT_REQUEST_LIST_ASSERT_MESSAGE = "El parámetro SortRequests debe contener elementos no nulos";
	
	public static final String RECORDS_PER_PAGE_ASSERT_MESSAGE = "Los registros por página deben ser mayores que 0";
	
	public static final String PAGINATE_PAGES_ASSERT_MESSAGE = "Las páginas paginadas deben ser mayores que 0";
	
	public static final String PAGEABLE_PAGINATE_PAGE_ASSERT_MESSAGE = "Los registros por página no deben ser nulos";
	
	public static final String PAGEABLE_NO_RECORDS = "No existe información a mostrar";
	
	public static final String PAGEABLE_PAGE_REQUIRED = "El parámetro Page no debe ser nulo";
	
	public static final String PAGEABLE_PAGE_DATA_REQUIRED = "Los datos de la página no deben ser nulos";
	
	public static final String PAGEABLE_PAGINATE_RESULT = "Mostrando {0} {1}";
	
	public static final String PAGEABLE_SHOWING_RECORDS = "Mostrando {0}-{1} de {2} registros";
	
}