import useGlobalToastr from "../context/toastr.context";


export function useToastr() {
  const [, setToastr] = useGlobalToastr();

  function showToastr(mensagem) {
    setToastr(mensagem);
  }

  return showToastr;
}
