package museum.service;

import museum.dto.worker.*;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.exception.EntityConstraintException;
import museum.exception.WorkerStatException;

import java.util.List;

/**
 * Service interface for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface WorkerService {

  /**
   * Save worker.
   *
   * @param workerSaveDto request worker dto.
   */
  void save(WorkerSaveDto workerSaveDto);

  /**
   * Get all workers.
   *
   * @return List of workerFirstSecondNameDtoResponse;
   */
  List<WorkerNamesDto> findAll();

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @throws BadIdException if worker with entered id doesn't exist.
   * @return worker;
   */
  WorkerDto findById(Long id) throws BadIdException;

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @throws BadNameException if worker with entered name doesn't exist.
   * @return id of worker;
   */
  Long findWorkerIdByName(String name) throws BadNameException;

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerNamesDto> findAllFreeGuide();

  /**
   * Get all guides.
   *
   * @return List of WorkerDtoResponse;
   */
  List<WorkerNamesDto> findAllGuide();

  /**
   * Get guides statistic.
   *
   * @throws WorkerStatException if excursions doesn't exist.
   * @return List of WorkerStatDtoResponse;
   */
  List<WorkerStatDto> findGuidesStat() throws WorkerStatException;

  /**
   * Delete worker by id.
   *
   * @throws EntityConstraintException if worker has some responsibility (serve halls or has
   *     excursion).
   * @param id worker id.
   */
  void deleteById(Long id) throws EntityConstraintException;

  /**
   * Get worker by id..
   *
   * @throws BadIdException if worker with entered id doesn't exist.
   * @return Worker;
   */
  Worker getOneById(Long id) throws BadIdException;

  /**
   * Update worker info.
   *
   * @param workerEditDto request worker dto.
   */
  void update(WorkerEditDto workerEditDto);
}
